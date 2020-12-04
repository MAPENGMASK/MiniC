# MiniC（eclipse）
基于javacc的MiniC语法分析器

## javaCC

JavaCC全称为Java Compiler Compiler，它是一个生成器，用于生成词法分析器（lexical analysers）和语法分析器（parsers）。

它可以通过读取一个词法和语法描述文件（即词法和语法描述是写在同一个文件中的），来生成一个java程序，这个java程序就包括了词法分析器和语法分析器。接着就可以用生成的词法分析器和语法分析器来对我们的输入进行判断，判断输入是否符合我们所要求的语法规则。

## 实现流程

- 程序以文件方式读入；

- 词法分析；

- 语法分析；

- 语义分析；

- 符号表，语义错误检查

- 结果以文件方式输出；


## 核心文件介绍

- cn.edu.com

MyNewGrammar.jjt----词法和语法描述文件

TokenMgrError----定义错误的类，它是Throwable类的子类，用于定义在词法分析阶段检测到的错误。

ParseException----定义错误的类。它是Exception 和Throwable的子类，用于定义在语法分析阶段检测到的错误。

Token----用于表示token的类。在.jj文件中定义的每一个token（PLUS, NUMBER, or EOF），在Token类中都有对应的一个整数属性来表示，此外每一个token都有名为image的string类型的属性，用来表示token所代表的从输入中获取到的真实值。

SimpleCharStream----转接器类，用于把字符传递给语法分析器。

MyNewGrammarConstants----一个接口，里面定义了一些词法分析器和语法分析器中都会用到的常量。

MyNewGrammarTokenManager----是词法分析器。

MyNewGrammar----是语法分析器。

## 顶级文件（目录）介绍

src.edu.com---源码

src.edu.ui---ui

src.edu.util---符号表，四元式定义，变量定义等

src.edu.xx.txt---中间结果（二元式，语法树，变量表等）
   
test---测试用例

MyNewGrammar.html----BNF

AmaterasUML----绘图插件

sf-eclipse.javacc----JAVACC插件

## 运行

cn.edu.ui.View.java
