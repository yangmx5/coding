
function iconv_java_to_utf8 {
    for JAVA_FILE in $(find . -name "*.java")
    do
        if [ "$(file $JAVA_FILE | grep -v UTF-8)" != "" ] ;then
            echo convert $JAVA_FILE
	    cp $JAVA_FILE $JAVA_FILE.gbk
            iconv -f GBK -t UTF-8 $JAVA_FILE.gbk > $JAVA_FILE
	    rm $JAVA_FILE.gbk
        fi
    done
}

iconv_java_to_utf8

