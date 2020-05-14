package fib

func Fibonacci() func() int {
	a, b := 0, 1
	//递归
	return func() int {
		a, b = b, a+b
		return a
	}
}
func main() {

}
