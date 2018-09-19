[ ! -n "$1" ] && echo "没有传配置文件路径" && exit 1
java -jar mybatis-generator-core-1.3.2.jar -configfile $1 -overwrite
#这会告诉 MBG 使用配置文件去运行。 MBG还会覆盖已经存在的同名Java文件。 如果您想保留已经存在的Java文件，您可以忽略 -overwrite 参数。 如果存在冲突, MBG 会用一个唯一的名字保存新生成的文件（例如：MyClass.java.1)。