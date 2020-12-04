# MiniC
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


MyNewGrammar.html----BNF

MiniC----答辩ppt

AmaterasUML----绘图插件

sf-eclipse.javacc----JAVACC插件

运行：cn.edu.ui.View.java
