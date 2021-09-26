[TOC]

### 1_学习HTML

#### 1.1 从网页开始

##### 1.1.1 为什么学习HTML

当我们在Chrome浏览器上，拿着`url`向服务器发出请求的时候，服务返回的是一个带有`HTML`文档的数据包，经过浏览器解析，网页才能在窗口上正常呈现。

python没有内置Chrome浏览器。

在用python请求了远程服务器之后，拿到的内容，最常见的，会是一份原汁原味的`HTML`文档。

如果把HTML的学习依序分为三个层次的话，应该是读懂、修改、编写。

##### 1.1.2 什么是HTML

HTML是用来描述网页的一种语言，英文全称是Hyper Text Markup Language，也叫超文本标记语言。

**标记语言**就是把**文本**和文本以外的相关**信息**（例如大小，高度，颜色，位置等）组合在一起的语言。

##### 1.1.3 查看网页源代码

在网页任意地方点击鼠标右键，然后点击“显示网页源代码”。（Windows系统的电脑还可以使用快捷键ctrl+u来查看网页源代码）

![image-20210926124026407](C:\Users\徐浩钦\AppData\Roaming\Typora\typora-user-images\image-20210926124026407.png)

![image-20210926124103808](C:\Users\徐浩钦\AppData\Roaming\Typora\typora-user-images\image-20210926124103808.png)

#### 1.2 HTML的组成

![img](https://res.pandateacher.com/CLeWOrD_cLeunm9RHkihIY1br0awOrD_KPhFAuA67d8pzuq9.png)

`HTML`文档主要由**元素**组成。

第一行`<!DOCTYPE html>`是一个全局声明，目的是告诉浏览器，你现在处理的这个文档是`HTML`文档。

HTML代码一共有**三组**基本元素，分别是html元素（`<html></html>`），head头元素（`<head></head>`），和body主体元素（`<body></body>`）。

它们成对出现，都带有尖括号（`<>`&`</>`），分别代表着元素的**起点**和**终点**。

最外层是`<html>`(**文档起点**)`</html>`（**文档终点**），它的作用是标记文档的起始位置和终止位置，从层级上来看，显然是老大，将`<head></head>`（头部）和`<body></body>`（主题）包裹了起来。

##### 1.2.1 层级结构

HTML和python一样，**【有缩进】**，这缩进将文档之间的那点**结构层级**安排地明明白白。

头部元素（`<head></head>`）内，一般会被用来设置网页的编码，添加网页标签的小logo，小标题，外部文件引用

HTML文档的主体元素（`<body></body>`）负责定义网页窗口内的所有内容，同时也是今后我们重点关注的对象。

##### 1.2.2 标签

**标签**用于标记文本信息，指用尖括号（`<>`和`</>`）括起来的字母和英文，形式有两种：**闭合标签**和**空标签**。

- **闭合标签**，它们绝大多数成对出现（有开始标签`<>`,也有结束标签`</>`），如：`<title>和</title>`是标题标签，`<div>和</div>`是块标签，`<form>和</form>`是表单标签。
- **空标签**，顾名思义，指那些“孤苦伶仃”的单标签，它们“形影单只”只有一个尖括号`<>`（斜杠`/`可省略），标签开始即结束，比如上面的`<img />`是图片标签，`<link />`是链接标签，`<input />`是input标签。

![img](https://res.pandateacher.com/20200320152756.png)

`<!-- -->`作用相当于python中的`#`，是HTML的注释方式。

##### 1.2.3 属性

![img](https://res.pandateacher.com/41B85207-7F1E-4046-BE2B-D98E417DFAB9.png)

属性都由**赋值语句**构成。

属性名就是属性（eg：name, style）

属性的书写方式（赋值）让人一目了然，却也有一个致命的问题，若一个标签具有多个属性（如大小、颜色、间距、对齐方式），结构就会变得十分冗杂，严重影响阅读体验，像这样：

```html
<h1 font-weight='bold' align='center' letter-spacing='2px' style="color: #20b2aa;">这个杀手不太冷</h1>
```

有个通用的`style`属性能把所有的样式以**键值对**的形式收集起来，像这样：

```html
<h1 style="font-weight:bold;text-align:center;letter-spacing:2px;color: #20b2aa;">这个书苑不太冷</h1>
```

可是，这样“长篇累牍”的代码还是不够优雅。于是，脆将`style`属性样式全部抽离出来。

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <style>
            /*规定h1的具体样式*/
            h1 {
                font-weight: bold;/*控制元素字体粗细*/
                text-align: center;/*控制元素对齐方式*/
                letter-spacing: 2px;/*控制文本字符的间距*/
                color: #20b2aa;/*控制元素的颜色*/
            }
        </style>
    </head>
    <body>
        <h1>这个书苑不太冷</h1>
    </body>
</html>
```

标签`<h1>`只管增添文本内容，文本样式的控制权交给head元素的`<style>`标签。

但是！这样一来，所有的h1元素都一个模样了！

为了解决这个问题，`HTML`文档诞生了两个最为特殊的**元素**：`class`和`id`。

##### 1.2.4 属性：class&id

在python中，可将相同的属性和方法的对象抽象成`类`，关键词是`class`。

![img](https://res.pandateacher.com/2019-09-12-15-10-04-201991215106.png)

在HTML文档中，我们也有一个关键词为`class`的属性，`class`属性值相同的元素可复用同一套样式。

![img](https://res.pandateacher.com/%E7%BC%96%E7%BB%84%208.jpg)

我们可以这么理解：`class`属性的作用是给元素增添类名，多个元素可配置一个类名，类名相同的元素沿袭同一套样式。

`id`属性则刚好和`class`属性相反，整个HTML文档，它是独一无二的标识，每个`id`值只能定义一个元素。

如若今后要爬取的元素带有`id`属性，那么恭喜💐你！这个元素具有唯一的标识，有了`id`，从千万元素中取值，犹如探囊取物。

在`<style>`标签中定义class属性的样式用点`.`，id属性用井号键`#`

#### 1.3 HTML技巧

1.点击红圈处

![image-20210926145338558](C:\Users\徐浩钦\AppData\Roaming\Typora\typora-user-images\image-20210926145338558.png)

当鼠标放在网页上，右边代码区中描述它的代码会被标亮出来：

![image-20210926145447006](C:\Users\徐浩钦\AppData\Roaming\Typora\typora-user-images\image-20210926145447006.png)

2.双击HTML文本

![image-20210926145739459](C:\Users\徐浩钦\AppData\Roaming\Typora\typora-user-images\image-20210926145739459.png)

将其改为任意文本后退出

![image-20210926145824743](C:\Users\徐浩钦\AppData\Roaming\Typora\typora-user-images\image-20210926145824743.png)

本地页面也会改变

![image-20210926145932711](C:\Users\徐浩钦\AppData\Roaming\Typora\typora-user-images\image-20210926145932711.png)

刷新网页后消失