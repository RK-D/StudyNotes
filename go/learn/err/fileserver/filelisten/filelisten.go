package filelisten

import (
	"io/ioutil"
	"net/http"
	"os"
	"strings"
)

const prefix = "/list/"

type userError string

func (e userError) Error() string {
	return e.Message()
}
func (e userError) Message() string {
	return string(e)
}

//抛出err抛出，交给外面处理
func HttpFileList(writer http.ResponseWriter, request *http.Request) error {
	if strings.Index(
		request.URL.Path, prefix) != 0 {
		return userError("path must start" + prefix)
	}
	path := request.URL.Path[len("/list/"):]
	file, err := os.Open(path)
	if err != nil {
		//直接写会暴露出错信息
		//包装
		//http.Error(
		//	writer,
		//	err.Error(),
		//	http.StatusInternalServerError)
		return err
		//panic(err)
	}
	defer file.Close()
	all, err := ioutil.ReadAll(file)
	if err != nil {
		//panic(err)
		return err
	}
	writer.Write(all)
	//没错时返回nil
	return nil
}
