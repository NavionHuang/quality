/*
 @Author: 请叫我马哥
 @Time: 2017-04
 @Tittle: tab
 @Description: 点击对应按钮添加新窗口
 */

layui.define(["element", "jquery"], function (exports) {

    var element = layui.element,
        $ = layui.jquery,
        layId,
        Tab = function () {
            this.tabConfig = {
                closed: true,
                openTabNum: undefined,  //最大可打开窗口数量
                tabFilter: "bodytab"  //添加窗口的filter
            }
        };


    //参数设置
    Tab.prototype.set = function (option) {
        var _this = this;
        $.extend(true, _this.tabConfig, option);
        return _this;
    };

    //通过title获取lay-id
    Tab.prototype.getLayId = function (title) {
        $(".layui-tab-title.top_tab li").each(function () {
            if ($(this).find("span").text() == title) {
                layId = $(this).attr("lay-id");
            }
        });
        return layId;
    }
    //通过title判断tab是否存在
    Tab.prototype.hasTab = function (title) {
        var tabIndex = -1;
        $(".layui-tab-title.top_tab li").each(function () {
            if ($(this).find("span").text() == title) {
                tabIndex = 1;
            }
        });
        return tabIndex;
    }

    //右侧内容tab操作
    var tabIdIndex = 0;
    Tab.prototype.tabAdd = function (_this) {
        var menu;
        if (window.sessionStorage.getItem("menu")) {
            menu = JSON.parse(window.sessionStorage.getItem("menu"));
        } else {
            menu = [];
        }
        var that = this;
        var closed = that.tabConfig.closed,
            openTabNum = that.tabConfig.openTabNum,
            tabFilter = that.tabConfig.tabFilter;
        if (_this.attr("target") == "_blank") {
            window.open(_this.attr("data-url"));
        } else {
            var title = '';
            if (_this.find("i.layui-icon").attr("data-icon") != undefined) {
                title += '<i class="layui-icon">' + _this.find("i.layui-icon").attr("data-icon") + '</i>';
            }
            //已打开的窗口中不存在
            if (that.hasTab(_this.find("span").text()) == -1 && _this.siblings("dl.layui-nav-child").length == 0 && _this.attr("data-url")) {
                if ($(".layui-tab-title.top_tab li").length == openTabNum) {
                    layer.msg('只能同时打开' + openTabNum + '个选项卡哦。不然系统会卡的！');
                    return;
                }
                tabIdIndex++;
                title += '<span>' + _this.find("span").text() + '</span>';
                title += '<i class="layui-icon layui-unselect layui-tab-close" data-id="' + tabIdIndex + '">&#x1006;</i>';
                element.tabAdd(tabFilter, {
                    title: title,
                    content: "<iframe src='" + _this.attr("data-url") + "' data-id='" + tabIdIndex + "'></frame>",
                    id: new Date().getTime()
                });
                //当前窗口内容
                var curmenu = {
                    "icon": _this.find("i.iconfont").attr("data-icon") != undefined ? "" : _this.find("i.layui-icon").attr("data-icon"),
                    "title": _this.find("span").text(),
                    "href": _this.attr("data-url"),
                    "layId": new Date().getTime()
                };
                menu.push(curmenu);
                window.sessionStorage.setItem("menu", JSON.stringify(menu)); //打开的窗口
                window.sessionStorage.setItem("curmenu", JSON.stringify(curmenu));  //当前的窗口
                element.tabChange(tabFilter, that.getLayId(_this.find("span").text()));
            } else {
                //当前窗口内容
                var curmenu = {
                    "icon": _this.find("i.iconfont").attr("data-icon") != undefined ? "" : _this.find("i.layui-icon").attr("data-icon"),
                    "title": _this.find("span").text(),
                    "href": _this.attr("data-url")
                };
                window.sessionStorage.setItem("curmenu", JSON.stringify(curmenu));  //当前的窗口
                element.tabChange(tabFilter, that.getLayId(_this.find("span").text()));
            }
        }
    };

    Tab.prototype.closeAll = function () {
        var tabFilter = this.tabConfig.tabFilter;
        if ($(".layui-tab-title.top_tab li").length > 1) {
            $(".layui-tab-title.top_tab li").each(function () {
                if ($(this).attr("lay-id") != '') {
                    element.tabDelete(tabFilter, $(this).attr("lay-id")).init();
                }
            });
        } else {
            layer.msg("没有可以关闭的窗口了");
        }
        window.sessionStorage.removeItem("menu");
        window.sessionStorage.removeItem("curmenu");
    };

    Tab.prototype.closeOther = function () {
        var tabFilter = this.tabConfig.tabFilter;
        var menu = JSON.parse(window.sessionStorage.getItem("menu"));
        $(".layui-tab-title.top_tab li").each(function () {
            if ($(this).attr("lay-id") != '' && !$(this).hasClass("layui-this")) {
                element.tabDelete(tabFilter, $(this).attr("lay-id")).init();
                //此处将当前窗口重新获取放入session，避免一个个删除来回循环造成的不必要工作量
                for (var i = 0; i < menu.length; i++) {
                    if ($(".layui-tab-title.top_tab li.layui-this span").text() == menu[i].title) {
                        menu.splice(0, menu.length, menu[i]);
                        break;
                    }
                }
            }
        });
        window.sessionStorage.setItem("menu", JSON.stringify(menu));
    };

    Tab.prototype.reflush = function (_this) {
        $(".child-iframe .layui-tab-item.layui-show").find("iframe")[0].contentWindow.location.reload(true);
        /*if ($(_this).hasClass("refreshThis")) {
            $(_this).removeClass("refreshThis");

        } else {
            setTimeout(function () {
                $(".refresh").addClass("refreshThis");
            }, 2000);
        }*/
    };


    $("body").on("click", ".top_tab li", function () {
        //切换后获取当前窗口的内容
        var tabFilter = bodyTab.tabConfig.tabFilter;
        var curmenu = '';
        var menu = JSON.parse(window.sessionStorage.getItem("menu"));
        curmenu = menu[$(this).index() - 1];
        if ($(this).index() == 0) {
            window.sessionStorage.setItem("curmenu", '');
        }
        element.tabChange(tabFilter, $(this).attr("lay-id")).init();
    });

    //删除tab
    $("body").on("click", ".top_tab li i.layui-tab-close", function () {
        var tabFilter = bodyTab.tabConfig.tabFilter;
        //删除tab后重置session中的menu和curmenu
        var liIndex = $(this).parent("li").index();
        var menu = JSON.parse(window.sessionStorage.getItem("menu"));
        //获取被删除元素
        var delMenu = menu[liIndex - 1];
        var curNav;
        var curmenu = window.sessionStorage.getItem("curmenu") == "undefined" ? undefined : window.sessionStorage.getItem("curmenu") == "" ? '' : JSON.parse(window.sessionStorage.getItem("curmenu"));
        if (JSON.stringify(curmenu) != JSON.stringify(menu[liIndex - 1])) {  //如果删除的不是当前选中的tab
            curNav = JSON.stringify(curmenu);
        } else {
            if ($(this).parent("li").length > liIndex) {
                window.sessionStorage.setItem("curmenu", curmenu);
                curNav = curmenu;
            } else {
                window.sessionStorage.setItem("curmenu", JSON.stringify(menu[liIndex - 1]));
                curNav = JSON.stringify(menu[liIndex - 1]);
            }
        }
        menu.splice((liIndex - 1), 1);
        window.sessionStorage.setItem("menu", JSON.stringify(menu));
        window.sessionStorage.setItem("curmenu", JSON.stringify(curNav));
        element.tabDelete(tabFilter, $(this).parent("li").attr("lay-id")).init();
    });


    var bodyTab = new Tab();
    exports("bodytab", bodyTab);
});