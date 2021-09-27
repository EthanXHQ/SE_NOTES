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