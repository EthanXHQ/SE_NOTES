import requests

res = requests.get("https://avatars.githubusercontent.com/u/71968425?v=4")
pic = res.content # 新建了一个文件ppt.jpg，这里的文件没加路径，它会被保存在程序运行的当前目录下。
photo = open("Beelzebub.jpg", "wb") # 在开始前可以去当前目录下找找有没有这张照片——咦？好像没有哦
photo.write(pic)
photo.close() # 现在就有可爱的别西法啦