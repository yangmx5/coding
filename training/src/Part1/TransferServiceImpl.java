package src.Part1;

/**
 * 分布式事务一致性: 继承该接口实现二阶段分布式事务的提交。参考 tcc 设计实现
 **/
public class TransferServiceImpl implements TransferService {
    /**
     * TransferServiceImpl
     *
     * @author yangmx
     * @date 2019/11/14
     */
    private AccountServiceImpl from;
    private AccountServiceImpl to;
    private Double money;
    private Long fromLogId;
    private Long toLogId;


    public TransferServiceImpl(AccountServiceImpl from, AccountServiceImpl to, Double money) {
        this.from = from;
        this.to = to;
        this.money = money;

    }

    @Override
    public void execute(Record record) {
        /*
          幂等: 通过 record 的全局唯一 id 保证接口幂等
         */
        if (!record.check()) {
            System.out.println("转账中");
            return;
        }

        if (this.prepare()) {
            confirm();
        } else {
            /*
                异常情况取消事务
                可能的情况:
                    1.网络问题,数据库服务问题
                    2.锁获取失败
             */
            cancel();
        }
    }

    @Override
    public boolean prepare() {
        try {
            //余额检查
            if (from.getMoney() < money) {
                fromLogId = null;
                toLogId = null;
                return false;
            }
//            fromLogId = from.createTransaction(money);
//            toLogId = to.createTransaction(money);
        } catch (Exception e) {
            // 可能的事务异常
            return false;
        }
        return true;
    }

    @Override
    public void confirm() {
        /*
            数据达到最终一致时退出循环
            根据需要可增加超时机制
         */
        while (true) {
            if (from.confirm(fromLogId) && to.confirm(toLogId)) {
                break;
            }
        }
    }

    @Override
    public void cancel() {
        /*
            幂等的撤回操作
         */
        from.cancel(fromLogId);
        to.cancel(toLogId);
    }

    public static void main(String[] args) {
        /*
            使用示例
         */

        AccountServiceImpl fromAccount = new AccountServiceImpl();
        AccountServiceImpl toAccount = new AccountServiceImpl();

        //安全: 对外暴露两个账户和转账金额和转账记录id
        TransferService service = new TransferServiceImpl(fromAccount, toAccount, 10.12);
        service.execute(new Record());
    }
}

