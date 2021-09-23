# COA2021第一次上机作业

在Transformer类中实现以下6个方法

1. 

``` java
 public String intToBinary(String numStr) 
```

将整数真值（十进制表示）转化成补码表示的二进制，默认长度32位

2. 

``` java
 public String binaryToInt(String binStr)
```

将补码表示的二进制转化成整数真值（十进制表示）

3. 

``` java
public String decimalToNBCD(String decimal)
```

将十进制整数的真值转化成NBCD表示（符号位用4位表示）

4. 

``` java
public String NBCDToDecimal(String NBCDStr)
```

将NBCD表示（符号位用4位表示）转化成十进制整数的真值

5.

```java
public String floatToBinary(String floatStr)
```

将浮点数真值转化成32位单精度浮点数表示

- 负数以"-"开头，正数不需要正号
- 考虑正负无穷的溢出（"+Inf", "-Inf"，见测试用例格式）

6.

```java
public String binaryToFloat(String binStr)
```

将32位单精度浮点数表示转化成浮点数真值

- 特殊情况同上
