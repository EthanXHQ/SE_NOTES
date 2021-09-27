[TOC]

### 2_BeautifulSoup

准备原材料：

`BeautifulSoup`库目前已经进阶到第4版（`Beautiful Soup 4`），由于它不是Python标准库，而是第三方库，需要单独安装它。

win10在终端输入一行代码运行：`pip install BeautifulSoup4`。（Mac电脑需要输入`pip3 install BeautifulSoup4`）

`BeautifulSoup`可以解析和提取网页中的数据。

#### 2.1【**解析数据**】

我们平时使用浏览器上网，浏览器会把服务器返回来的HTML源代码翻译为我们能看懂的样子，之后我们才能在网页上做各种操作。

`BeautifulSoup`解析数据的用法：

![img](https://res.pandateacher.com/d2g%2001-2019325115528.png)

在括号中，要输入两个参数，第1个参数是要被解析的文本，注意了，它必须是**字符串**。

括号中的第2个参数用来标识解析器，我们要用的是一个Python内置库：`html.parser`。（它不是唯一的解析器，却是简单的那个）

使用`BeautifulSoup`去解析数据：

```python
from bs4 import BeautifulSoup
soup = BeautifulSoup(字符串,'html.parser') 
```

eg:

```python
import requests
from bs4 import BeautifulSoup

res = requests.get("https://localprod.pandateacher.com/python-manuscript/crawler-html/spider-men5.0.html")
soup = BeautifulSoup(res.text, "html.parser")
print (type(soup))
print (soup)
```

虽然`response.text`和`soup`打印出的内容表面上看长得一模一样，却有着不同的内心，它们属于不同的类：`<class 'str'>` 与`<class 'bs4.BeautifulSoup'>`。前者是字符串，后者是已经被解析过的`BeautifulSoup`对象。之所以打印出来的是一样的文本，是因为BeautifulSoup对象在直接打印它的时候会调用该对象内的**str**方法，所以直接打印 bs 对象显示字符串是**str**的返回结果。



#### 2.2【**提取数据**】

是指把我们需要的数据从众多数据中挑选出来。

##### 2.2.1 `find()`与`find_all()`

`find()`与`find_all()`是`BeautifulSoup`对象的两个方法，它们可以匹配html的标签和属性，把BeautifulSoup对象里符合要求的数据都提取出来。

它俩的用法是一样的，区别在于它们**工作量**。

`find()`**只提取首个满足要求的数据**。`find()`方法将代码从上往下找，找到符合条件的第一个数据，不管后面还有没有满足条件的其他数据，停止寻找，立即返回。

而`find_all()`顾名思义，提取出的是**所有满足要求的数据**。代码从上往下找，一直到代码的最后，把所有符合条件的数据揣好，一起打包返回。

![img](https://res.pandateacher.com/2019-01-23-16-36-57.png)

括号里的`class_`，这里有一个下划线，是为了和python语法中的类 `class`区分，避免程序冲突。

除了用`class`属性去匹配，还可以使用其它属性，比如`style`属性等。

括号中的参数：标签和属性可以任选其一，也可以两个一起使用，这取决于我们要在网页中提取的内容。



eg：

`find()`

```python
import requests
from bs4 import BeautifulSoup
url = 'https://localprod.pandateacher.com/python-manuscript/crawler-html/spder-men0.0.html'
res = requests.get (url)
print(res.status_code)
soup = BeautifulSoup(res.text,'html.parser')
# 使用find()方法提取首个<div>元素，并放到变量item里。
item = soup.find('div') 
print(type(item))  
print(item)
```

我们还打印了它的数据类型：`<class 'bs4.element.Tag'>`，说明这是一个`Tag`类标签对象。

`find_all()`

```
import requests
from bs4 import BeautifulSoup
url = 'https://localprod.pandateacher.com/python-manuscript/crawler-html/spder-men0.0.html'
res = requests.get (url)
print(res.status_code)
soup = BeautifulSoup(res.text,'html.parser')
# 使用find()方法提取首个<div>元素，并放到变量item里。
items = soup.find_all('div') 
print(type(items))  
print(items)
```



eg：

**要求：**

（url：https://localprod.pandateacher.com/python-manuscript/crawler-html/spider-men5.0.html），目标是爬取网页中的三本书的书名、链接、和书籍介绍。

**过程：**

打开网址，在网页上点击右键-检查，查看源代码，先看一看目标数据所对应的位置。

![img](https://res.pandateacher.com/crawler-l2-7-0-2019118.png)

看见我们想要的每一本书的数据，分别存在了三个`div`元素中，并且有相同的属性：`class="books"`，这个共同点就是我们去提取数据的关键。

由于我们要找的不是一本书的数据，而是所有书的数据都要找，所以这时应该用`find_all()`。

接下来要考虑的就是，要用什么参数去查找和定位，标签，还是属性。此时，可以用到开发者工具的搜索功能，点击Ctrl+F，Mac电脑用command+F。

![img](https://res.pandateacher.com/crawler-l2-8-0-2019118.png)

一共找到了8个`div`元素，但我们只想找到3个，如果只用`<div>`来检索，就会把其它不需要的信息也提取出来。

这三个设计书籍信息的`div`样式很显然是一样的，`class`值都为`books`。

我们用属性`class="books"`搜索看看，果然，整个HTML源代码中，只有我们要找的三个元素的属性满足，因此，我们这次就可以只使用这个属性来提取。

P.S.：win10中若在`F12`下搜索只有纯英文字母搜索才有效，加入空格或其余符号均搜索不到；点击右键-显示网页源代码下搜索则无此问题。

```python
import requests 
from bs4 import BeautifulSoup 
res = requests.get('https://localprod.pandateacher.com/python-manuscript/crawler-html/spider-men5.0.html')
html= res.text
soup = BeautifulSoup( html,'html.parser') 
# 通过定位标签和属性提取我们想要的数据
items = soup.find_all(class_='books') 
for item in items:
    # 打印item元素，若直接打印items为列表
    print('想找的数据都包含在这里了：\n',item) 
```

##### 2.2.2 `Tag`对象

还以上面的代码为例，我们现在拿到的是一个个包含html标签的数据，还没达成目标。

这个时候，我们一般会选择用`type()`函数查看一下数据类型，因为Python是一门面向对象编程的语言，只有知道是什么对象，才能调用相关的对象属性和方法。

```python
import requests 
from bs4 import BeautifulSoup 
res = requests.get('https://localprod.pandateacher.com/python-manuscript/crawler-html/spider-men5.0.html')
html= res.text
soup = BeautifulSoup( html,'html.parser') 
# 通过定位标签和属性提取我们想要的数据
items = soup.find_all(class_='books') 
for item in items:
    # 打印item元素，若直接打印items为列表
    print('想找的数据都包含在这里了：\n',item) 
    print(type(item))
```

我们看到它们的数据类型是`<class 'bs4.element.Tag'>`，是`Tag`对象，这与`find()`提取出的数据类型是一样的。

###### `Tag`类对象的常用属性和方法

![img](https://res.pandateacher.com/crawler-l2-16-201919.png)

1.`Tag`对象可以使用`find()`与`find_all()`来继续检索。

```python
# 调用requests库
import requests 
# 调用BeautifulSoup库
from bs4 import BeautifulSoup 
# 返回一个response对象，赋值给res
res = requests.get('https://localprod.pandateacher.com/python-manuscript/crawler-html/spider-men5.0.html')
# 把res的内容以字符串的形式返回
html = res.text
# 把网页解析为BeautifulSoup对象
soup = BeautifulSoup( html,'html.parser') 
# 通过定位标签和属性提取我们想要的数据
items = soup.find_all(class_='books') 
for item in items:
    # 在列表中的每个元素里，匹配标签<h2>提取出数据
    kind = item.find('h2') 
    # 在列表中的每个元素里，匹配属性class_='title'提取出数据
    title = item.find(class_='title')
    # 在列表中的每个元素里，匹配属性class_='info'提取出数据 
    brief = item.find(class_='info') 
    # 打印提取出的数据
    print(kind,'\n',title,'\n',brief) 
    # 打印提取出的数据类型
    print(type(kind),type(title),type(brief))
```

除了我们拿到的数据之外；运行结果的数据类型，又是三个`<class 'bs4.element.Tag'>`，用`find()`提取出来的数据类型和刚才一样，还是`Tag`对象。接下来要做的，就是把`Tag`对象中的文本内容提出来。

2.这时，可以用到`Tag`对象的另外两种属性——`Tag.text`（获得标签中的值），和`Tag['属性名']`（获得属性值）。

我们用`Tag.text`提出`Tag`对象中的文字，用`Tag['href']`提取出URL。

只需要修改最后一行代码，我们想要的数据就都能成功提取出来了：

```python
# 调用requests库
import requests 
# 调用BeautifulSoup库
from bs4 import BeautifulSoup 
# 返回一个response对象，赋值给res
res =requests.get('https://localprod.pandateacher.com/python-manuscript/crawler-html/spider-men5.0.html')
# 把res解析为字符串
html=res.text
# 把网页解析为BeautifulSoup对象
soup = BeautifulSoup( html,'html.parser')
# 通过匹配属性class='books'提取出我们想要的元素
items = soup.find_all(class_='books')  
# 遍历列表items
for item in items:       
    # 在列表中的每个元素里，匹配标签<h2>提取出数据               
    kind = item.find('h2')     
    #  在列表中的每个元素里，匹配属性class_='title'提取出数据          
    title = item.find(class_='title')  
    # 在列表中的每个元素里，匹配属性class_='info'提取出数据   
    brief = item.find(class_='info')      
    # 打印书籍的类型、名字、链接和简介的文字
    print(kind.text,'\n',title.text,'\n',title['href'],'\n',brief.text)
```

