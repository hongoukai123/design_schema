步骤:
1、从腾讯云通信控制台下载公私钥文件private_key、public_key到本目录下。
2、修改WebRTCSigApi.java文件中的sdkappid、roomid、userid为腾讯云通信的sdkappid，指定房间号，指定用户名。
3、在本地运行 
    a. javac WebRTCSigApi.java
    b. java WebRTCSigApi
即可生成userSig和privMapEncrypt


PS: 您可以直接将 WebRTCSigApi类 拷贝到您的项目中使用