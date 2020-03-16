## Jenkins + Maven Docker 镜像定制版 
基于 Jenkins 官方镜像，安装了工具（如：Maven）以及一些插件（详见 plugins.txt）,并做了一些初始化操作（如：创建 admin 账号，设置认证授权策略）

## Jenkins 版本
2.204.5

备注：此时（2020/03/16）为 jekins lts 最新版本

## 安装工具
- Maven（版本：3.6.3）

## 插件列表
插件列表详见 [plugins.txt](plugins.txt)

## 管理员账号和密码
管理员账号密码：admin/9YxwvCOUPML8onXF

## 使用镜像
拉取镜像：`docker pull donhui/jenkins-with-maven:2.204.5`

运行容器：`docker run -p 8080:8080 -p 50000:50000 donhui/jenkins-with-maven:2.204.5`

运行容器（将 jenkins_home 挂载到本地）：
`docker run -p 8080:8080 -p 50000:50000 -v /var/jenkins_home:/var/jenkins_home jenkins/jenkins:2.204.5`

运行容器（将 jenkins_home 挂载到本地并在后台运行）：
`docker run -d -p 8080:8080 -p 50000:50000 -v /var/jenkins_home:/var/jenkins_home jenkins/jenkins:2.204.5`