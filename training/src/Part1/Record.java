public class Record {
    /*
      记录每笔转账交易,维护余额修改日志ID
     */
    Long recordId;
    //数据库自增id 保证接口幂等性。全局唯一
    Long fromLogId;
    Long toLogId;
    Double money;
    /*
        更多属性:创建日期,修改历史等。
     */

    boolean check() {
        /*
          查询库中是否有相同 record id 记录
         */
        return true;
    }
}