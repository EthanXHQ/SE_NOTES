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