###panic
* 停止当前执行
* 一直向上返回，执行每一层的defer
* 没recover时，会退出
###recover
* 仅在defer调用中使用
* 获取panic的值
* 如果没法处理可重新panic
###错误处理
* 意料之中：用error
* 意料之外： 用panic