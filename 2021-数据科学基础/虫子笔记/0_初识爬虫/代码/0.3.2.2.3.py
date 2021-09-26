import requests

res = requests.get("https://localprod.pandateacher.com/python-manuscript/crawler-html/sanguo.md") # 三国演义第一回
novel = res.text
k = open("three_kingdom.txt", "a+")
k.write(novel)
k.close()