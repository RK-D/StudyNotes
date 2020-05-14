cmake_minimum_required(VERSION 3.15)
project(basic)

set(CMAKE_CXX_STANDARD 11)

add_executable(basic
        "./pointer/pointer.cpp"
        "./derived/derived.cpp"
        "./module/module.cpp"
        )