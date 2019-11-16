interface AccountService {
    Long tryExecute(Double money);

    Boolean cancel(Long logId);

    Boolean confirm(Long logId);

}

public class AccountServiceImpl implements AccountService {
    /**
     * 账户思路(单个 tcc 服务)：
     * 1.增加 log 表记录账户余额变动日志
     * 2.转出预扣,转入冻结
     * 3.confirm 后日志标记完成。冻结资金释放
     *
     * @author yangmx
     * @date 2019/11/14
     **/

    public Double getMoney() {
        /**
         * 读取使用共享锁
         **/
        return 100.0;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Long tryExecute(Double money) {
        /**
         *  检查预留资源
         *  开启事务:
         *  money < 0:
         *      1.修改余额
         *      2.创建操作 log 记录转账金额 标记 log 转账中
         *      3.返回 logId
         *  money > 0:
         *      1.创建操作 log 记录转账金额 标记 log 入账中
         *      2。返回 logId
         **/


        return 123L;
    }

    @Override
    @Transactional(rollbackFor = Throwable.class)
    public Boolean cancel(Long logId) {
        /**
         *   释放资源
         *   开启事务:
         *   1.查询 logId 指定 log 若 log 状态不为已撤销,继续2。否则返回成功
         *   2.根据 log 恢复数据 标记 log 已撤销
         *   3.返回成功
         **/
        if (logId == null) {
            return true;
        }
        return true;

    }

    @Override
    public Boolean confirm(Long logId) {
        /**
         *   业务执行
         *   查询 log 状态若为 已完成 直接返回成功
         *   否则:
         *       money > 0:
         *           1.修改余额
         *           2.标记 log 已完成
         *       money < 0:
         *           1.标记 log 已完成
         *   返回成功
         **/
        return true;
    }

}
