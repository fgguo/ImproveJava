### Java的基本程序设计结构
#### 数据类型
##### 整型
- Java提供了4种整型:byte,short,int,long.
- Java中，整型的范围与运行Java代码的机器无关，而在C++中，int 和long等类型的大小与目标平台相关.
- 长整型有一个L或l后缀，十六进制有一个0X或0x前缀，八进制有一个0前缀，Java 7起，加上前缀0b或0B就可以写二进制数.
- Java没有任何无符号形式的int/long/short/byte.
##### 浮点类型
- float精度是6-7位有效数字，double精度是float的二倍
- float类型的数只有一个后缀F或f，没有后缀的浮点数默认为double
##### char类型
- 有些Unicode字符可用一个char值描述，另外一些需要两个
- char类型的字面量值要用单引号括起来
##### boolean类型
- Java中整型值和布尔值不能互相转换，在C++中，值0相当于false,非0值相当于true.
#### 变量与常量
- 变量名必须是一个以字母开头并由字母和数字组成的序列，不能使用保留字作为变量名
- 声明一个变量后，必须用赋值语句对变量进行显示初始化，变量的声明尽可能地靠近第一次使用的地方.
- Java 10 开始，对于局部变量，如果可以从变量的初始值推断出它的类型，就不需要声明类型。只需要使用关键字var而无需指定类型，如var greeting = "hello";则greeting是一个字符串
- 关键字final表示常量，一旦赋值就不能再更改了，通常，常量名使用全大写.
- 类常量的定义位于main方法的外部
#### 枚举类型
- 变量的取值只在一个有限的集合内时，可以定义枚举类型。如， enum Size {Small, Medium, Large};然后声明这种类型的变量:Size s = Size.Small.
#### 运算
- Math类中包含了各种数学函数，在文件顶部加入import static java.lang.Math.*;就可以直接使用方法，不必加前缀了
- 一个二元运算符连接两个值时，要先将两个操作数转为同一个数据类型，如果一个是double，另一个转换为double；否则如果一个是float，另一个会转为float;否则其中一个是long,另一个转为long；否则两个操作数都转为int
- 将double转为int这种会损失信息的转换需要通过强制类型转换完成，即在圆括号中给出想要转换的目标类型，比如
  double x = 9.999; int nx = (int)x;   
- 如果想要对浮点数进行舍入运算，需要使用Math.round方法。如，int nx = (int)Math.round(x);使用强制转换的原因是round返回的类型为long.
#### 字符串
- Java字符串就是Unicode字符序列，用双引号括起来.
- substring(0,3)表示提取0-3的子串，不包括位置3.
- Java字符串与一个非字符串的值拼接时，后者会转换为字符串
- 如果把多个字符串拼接在一起，并指定一个分隔符，可以使用join方法。如String all = String.join("/","S","M","L");
- 不能修改Java字符串中的单个字符
- 使用equals方法检测两个字符串是否相等，而不是使用==.
- 使用if(str.length()==0)或if(str.equals(""))判断空串
- 使用if(str == null)判断是否为null
- String的相关API在书50页
- 如果需要使用小段字符串来构建一个字符串，使用StringBuilder.
#### 输入与输出
- 读取控制台输入需要构造一个与"标准输入流"System.in关联的Scanner对象.Scanner in= new Scanner(System.in);
- nextLine方法将读取一行输入，nextInt读取一个整数，nextDouble读取下一个浮点数,next读取输入的下一个单词(以空格为分隔符),hasNext检测是否输入中还有其他单词.
- System.out.printf可以格式化输出，假如x = 3333.3333333，System.out.printf(%8.2f, x);表示以8个字符的宽度打印x，精度为小数点后2位。也就是说会打印一个前导空格和7个字符(3333.33).
- 每个以%字符开始的格式说明符都用相应的参数替换，常见的格式转换符有，d表示十进制数，x表示十六进制数，o表示八进制数，f表示定点浮点数，e表示指数浮点数，s表示字符串,c表示字符.
#### 控制流程
- 块(即复合语句)是指由若干条Java语句组成的代码块，并用一对大括号括起来.
- 条件语句if 
- 循环语句for,while
- 多重选择switch，switch(choice){case 1: ...break;default: ... break;};switch语句将从与选项值匹配的case标签开始，直到遇到break语句或到switch语句的结束处为止。如果没有匹配的case标签而有default字句，就执行这个语句.
- case标签可以是char/short/byte/int，枚举常量，Java 7开始还可以是字符串.
#### 大数
- 如果基本的整数和浮点数精度不能够满足需求，那么可以使用java.math中的BigInteger和BigDecimal。使用静态的valueOf方法可以将普通的数转为大叔，如BigInteger a = BigInteger.valueOf(100)；
- 不能使用算术运算符如+-*/处理大数，需要使用类中的方法，如add,multiply,divide等
#### 数组
- 声明，初始化，访问，for each循环遍历
- 如果希望将一个数组的所有值拷贝到一个新的数组，使用Arrays类的copyOf方法，第一个参数是源数组，第二个参数是新数组长度.
