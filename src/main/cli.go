package main

import (
	pb "../protoc"
)

type Hub struct {
	Name string
}

func csReceive(send *pb.ClioteSend) {
	switch send.Identifier {
	case "mg start":
	case "mg stop":
	case "mg add":
	case "mg requestid":
	case "hub add":
	case "hub remove":
	case "hub join":
	case "hub list":
	}
}

func csSend() {

}
