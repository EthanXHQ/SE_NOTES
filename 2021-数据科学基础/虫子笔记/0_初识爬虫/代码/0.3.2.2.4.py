import requests

res = requests.get('https://localprod.pandateacher.com/python-manuscript/crawler-html/sanguo.md')

# 定义Response对象的编码为gbk
res.encoding='gbk'

novel=res.text
print(novel[:800])