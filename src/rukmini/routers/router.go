package routers

import (
	"rukmini/controllers"
	"github.com/astaxie/beego"
)

func init() {
    beego.Router("/", &controllers.MainController{})
	beego.Router("/status", &controllers.StatusController{}, "get:StatusCheck" )
	beego.Router("/oor", &controllers.StatusController{}, "post:OutOfRotation" )
	beego.Router("/bir", &controllers.StatusController{}, "post:InRotation" )
	beego.Router("/image/:width:int/:height:int/*", &controllers.ResizeController{} )
}