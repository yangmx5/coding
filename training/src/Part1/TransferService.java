package src.Part1;

/**
 * @date 2023/3/27
 */
public interface TransferService {

    boolean prepare();

    void confirm();

    void cancel();

    void execute(Record record);
}
