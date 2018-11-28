/**自定义模块*/
layui.define(['layer'], function (exports) {
    var $ = layui.jquery,
        layer = layui.layer;
    var common = {

        /**错误msg提示 */
        layErrorMsg: function (text) {
            top.layer.msg(text, {icon: 5});
        },
        /**成功 msg提示 */
        laySucMsg: function (text) {
            top.layer.msg(text, {icon: 6});
        },
        /**弹出层提交*/
        ajaxCommit: function (url, param) {
            var index = top.layer.msg('数据提交中，请稍候', {icon: 16, time: false, shade: 0.8});
            $.ajax({
                url: url,
                type: 'post',
                data: param,
                dataType: 'json',
                success: function (res) {
                    top.layer.close(index);
                    if (res.code != 200) {
                        top.layer.msg(res.msg);
                    } else {
                        // 刷新父页面
                        //var frame = layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                        layer.closeAll("iframe"); //再执行关闭                        //刷新父页面
                        parent.location.reload();
                    }
                },
                error: function (e, m) {
                    top.layer.close(index);
                    top.layer.msg('数据提交异常',{time: 3000});
                }
            });
        },
        /**弹出层*/
        layOpen: function (title, url, width, height,full) {

            var index = layer.open({
                title: '<i class="larry-icon larry-bianji3"></i>' + title,
                type: 2,
                skin: 'layui-layer-molv',
                content: url,
                area: [width, height],
                resize: false,
                anim: 1,
                success: function (layero, index) {

                }
            });
            if(full)layer.full(index);
        },
        /**弹出层-tip*/
        layOpenTip: function (title, url, width, height) {
            var index = layer.open({
                title: '<i class="larry-icon larry-bianji3"></i>' + title,
                type: 2,
                skin: 'layui-layer-molv',
                content: url,
                area: [width, height],
                resize: false,
                anim: 1,
                success: function (layero, index) {
                    setTimeout(function () {
                        layer.tips('点击此处返回', '.layui-layer-setwin .layui-layer-close', {
                            tips: [3, '#009f95']
                        });
                    }, 500);
                }
            });
        },
        /**退出*/
        logOut: function (title, text, url, type, dataType, data, callback) {
            top.layer.confirm(text, {
                title: title,
                resize: false,
                btn: ['确定'],
                btnAlign: 'c',
                icon: 3
            }, function () {
                location.href = url
            }, function () {

            })
        }
    };
    exports('common', common)
})



