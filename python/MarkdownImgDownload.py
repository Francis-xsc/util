import requests
import os
import re

headers = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/117.0.0.0 Safari/537.36'
}
filename = input("文件名：")
if filename.endswith('.md'):
    filename = filename.replace('.md', '')
f = open(filename + '.md', 'r', encoding='utf-8')
text = f.read()
f.close()
res = re.findall(r'!\[.*?\]\((https?://.*?)\)', text)
if not os.path.exists('./' + filename + '/img/'):
    os.makedirs('./' + filename + '/img/')
i = 1
for url in res:
    with open(os.curdir + '/' + filename + '/img/' + str(i) + '.jpg', 'wb') as fp:
        fp.write(requests.get(headers=headers, url=url).content)
    h = os.curdir + '/' + filename + '/img/' + str(i) + '.jpg'
    text = text.replace(url, h)
    i += 1
with open(filename + '.md', 'w+', encoding='utf-8') as fp:
    fp.write(text)
print('完成')