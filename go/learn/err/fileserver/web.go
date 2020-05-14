package main

import (
	"./filelisten"
	"github.com/gopm/modules/log"
	"net/http"
	"os"
)

//error返回值参数类型,error是一个接口
//type error interface {
//	Error() string
//}
type appHandler func(writer http.ResponseWriter,
	request *http.Request) error

//func HandleFunc(pattern string, handler func(ResponseWriter, *Request)) {
//	DefaultServeMux.HandleFunc(pattern, handler)
//}
//
//var (
//	Trace   *log.Logger // 记录所有日志
//	Info    *log.Logger // 重要的信息
//	Warn *log.Logger // 需要注意的信息
//	Error   *log.Logger // 非常严重的问题
//)
//函数式编程，接入输入，包装输出
func errWrapper(handler appHandler) func(
	http.ResponseWriter,
	*http.Request) {
	return func(
		writer http.ResponseWriter,
		request *http.Request) {
		err := handler(writer, request)
		if err != nil {
			//log.Warn
			log.Warn(" [warn] err:%s", err.Error())
			code := http.StatusOK
			switch {
			// IsNotExist返回一个布尔值，指示是否知道该错误，以报告文件或目录不存在。
			//ErrNotExist以及一些系统调用错误都可以满足。
			case os.IsNotExist(err):
				code = http.StatusNotFound
			case os.IsPermission(err):
				code = http.StatusForbidden
			default:
				code = http.StatusInternalServerError
			}
			http.Error(
				writer,
				//err.Error() 这种写法会对用户暴露后台的错误，不可取
				http.StatusText(code), //302
				code)
		}
	}
}

//panic会保护起来，防止服务器宕掉
func main() {
	http.HandleFunc("/list/", errWrapper(filelisten.HttpFileList))
	err := http.ListenAndServe(":8848", nil)
	if err != nil {
		panic(err)
	}
}
