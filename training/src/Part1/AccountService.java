package src.Part1;

/**
 * @date 2023/3/27
 */
public interface AccountService {
    Long tryExecute(Double money);

    Boolean cancel(Long logId);

    Boolean confirm(Long logId);
}
