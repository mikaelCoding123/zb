# 不知道文件名时都是默认命名为a
用g++ 来编译 cpp文件
## 指定可执行文件名
g++ 123.cpp -o ehw

## 指定编码格式编译
g++ -fexec-charset=GBK main.cpp -o main.exe && main.exe
## gcc指定可执行文件名
gcc .\test03.c -o test03
gcc -fexec-charset=GBK main.c -o main.exe