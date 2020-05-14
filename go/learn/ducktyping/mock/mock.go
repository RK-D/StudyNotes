package mock

type Retriever struct {
	Contents string
}

func (r *Retriever) Get(url string) string {
	return r.Contents
}

//Retriever加* 用于修改Contents
func (r *Retriever) Post(url string, form map[string]string) string {
	r.Contents = form["contents"]
	return "yes"
}
