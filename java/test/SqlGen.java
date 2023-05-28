package test;

import java.util.List;

/**
 * @author fouthed
 * @date 2023/4/18
 */
public class SqlGen {

    public static void main(String[] args) {
        String authorIdListStr = "[\n" +
                "  \"636f7ea3000000001f01b60e\",\n" +
                "  \"5b929c321b34120001021eee\",\n" +
                "  \"587a3c255e87e729792eaefd\",\n" +
                "  \"56d56a9e4775a74d8f0c2a27\",\n" +
                "  \"MS4wLjABAAAA4lQ8-ogJdYF2nW3OySEaX2Odcj_2ZsKiP58cWcXGJLLSb9CnCvn2c5lB8G9oC9tx\",\n" +
                "  \"MS4wLjABAAAAwSalq4kTOxundfgq6w9qwiwWSHFr4U9mHcKQ2teCLJE\",\n" +
                "  \"MS4wLjABAAAAh1-zhQzWjxS1e4tYH_TJgIJqLHsZ4zfpDj8oS-ru8GFCQPM1uX6MfmlrMo6fA0fE\",\n" +
                "  \"MS4wLjABAAAAzFdX8WC3gBKkzC_rkVaHZYQTkTCWihMxezWmdPjZmKY\",\n" +
                "  \"MS4wLjABAAAAgOdTgfqJv8Nprz9O2kz6E6GDlYtLkHzY3KtETSespwzLZoQ46AARs8AZB1dfJ0Vb\",\n" +
                "  \"MS4wLjABAAAAkMFii075aCsgxLmkfEzYXrrX8M32TP5AT2Qjkz6q8RfsHA0ZMpTALI4qVTCwsz2K\",\n" +
                "  \"MS4wLjABAAAA8JE3IK3gFmJOaNaZrbb6saeKB1S-WqlC1ODGNTqiYj-lthaC7aoIxjqyWih-Dfka\",\n" +
                "  \"MS4wLjABAAAAcO0-dFBWejckBu-C2vHejyII0xeWhrpgNuz1ntPSb0Hmf5Be4jE9Hr7TRfeHGZiK\",\n" +
                "  \"MS4wLjABAAAA57ne75SSIktp-zp5uB0KSBDyvrKYGaCYWPEPQfVUXOvxu-AxNOictSZayGyzdSKl\",\n" +
                "  \"5a6b55c911be103a9bcf7a83\",\n" +
                "  \"57ea920250c4b43314c66ffd\",\n" +
                "  \"5e34c1aa000000000100a78b\",\n" +
                "  \"5e8c8b230000000001008294\",\n" +
                "  \"5dc8f09300000000010006d1\",\n" +
                "  \"5ceb5c7f0000000018030234\",\n" +
                "  \"MS4wLjABAAAAL6fVxDQP1suB9UvdgEvvsCdaIQB-etH3sJb6ExPGmM5_5VupiIo2MHEV6ZZLhdxV\",\n" +
                "  \"MS4wLjABAAAAAse4Mtm4Cc0aE8x_-XJRoV8kV5dRLEylT_QTjLGp_s0\",\n" +
                "  \"MS4wLjABAAAAnZnSkOPfYEvz37ydDstCrPOVqQQmN08u3H5V9egJsPk\",\n" +
                "  \"MS4wLjABAAAAQAr2nE434EpjLVzAPygB76Xi8Pzwm92TreQPb6fZqW8\",\n" +
                "  \"5b1d3159e8ac2b2b93c04229\",\n" +
                "  \"ks17862565237\",\n" +
                "  \"3x8xurcmh8d4zg9\",\n" +
                "  \"59ce63e420e88f79aece0bcd\",\n" +
                "  \"MS4wLjABAAAAZIAxQizQ-LseNYwKlbagxWfcx42bW4s0IEUgQxppD7I\",\"MS4wLjABAAAA3Ra4F8x4aWCltC8sOtrRxdE5-9ufQLopuJ8M30w8G0w7hEK-YXVWgLdwotlHhOtf\",\n" +
                "  \"MS4wLjABAAAA1cDiHpqzm-0SdqRovHXTQeGjPfj8p8UmM5_0eojlKco\",\n" +
                "  \"5687306aaed7583ad821db19\",\n" +
                "  \"5b2528484eacab3046be89f3\",\n" +
                "  \"55a7ab36c2bdeb6292192d35\",\n" +
                "  \"5c94f9660000000016020aaf\",\n" +
                "  \"434907373\",\n" +
                "  \"5b3df32311be10755af0e1f4\",\n" +
                "  \"6157f07f000000001f0347cf\",\n" +
                "  \"61ac4069000000001000ad09\",\n" +
                "  \"5888c72c50c4b45d8232f728\"]\n";


        String sqlTemplate = "update Recop_Bd_Author set dpauthorid = null where orgid = '%s';\n" +
                "update Recop_Bd_Clue set bdstatus = 0,bpmtaskstatus=0 where authorid in (select authorid from Recop_Bd_Author where orgid = '%s');\n" +
                "update Recop_Bd_Content_Import set planstatus = 0 where authorid in (select authorid from Recop_Bd_Author where orgid = '%s');\n";

        System.out.println(sqlTemplate.replace("%s", "5b929c321b34120001021eee"));


    }
}
