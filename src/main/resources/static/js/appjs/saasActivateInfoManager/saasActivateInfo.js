
var prefix = "/saasActivateInfo"
$(function() {
	load();
});

layui.use(['upload'],function(){
var $ = layui.jquery,
upload = layui.upload;
upload.render({
    elem: '#uploadExcel',
    url: prefix + '/uploadExcel',
    accept: 'file', //普通文件
    ext : 'xls|xlsx',
    title : '请选择Excel文件',
    before: function(obj){ //obj参数包含的信息，跟 choose回调完全一致，可参见上文。
        layer.load(); //上传loading
    },
    done: function(res, index, upload){
        layer.closeAll('loading'); //关闭loading
        if(res.code == 0){
            top.layer.msg(res.msg, {icon: 6});
        }else{
            top.layer.msg(res.msg, {icon: 5});
        }
        reLoad();
    },
    error: function(){
        //请求异常回调
    }     
});
});
function load() {
	$('#exampleTable')
			.bootstrapTable(
					{
						method : 'get', // 服务器数据的请求方式 get or post
						url : prefix + "/list", // 服务器数据的加载地址
					//	showRefresh : true,
					//	showToggle : true,
					//	showColumns : true,
						iconSize : 'outline',
						toolbar : '#exampleToolbar',
						striped : true, // 设置为true会有隔行变色效果
						dataType : "json", // 服务器返回的数据类型
						pagination : true, // 设置为true会在底部显示分页条
						// queryParamsType : "limit",
						// //设置为limit则会发送符合RESTFull格式的参数
						singleSelect : false, // 设置为true将禁止多选
						// contentType : "application/x-www-form-urlencoded",
						// //发送到服务器的数据编码类型
						pageSize : 10, // 如果设置了分页，每页数据条数
						pageNumber : 1, // 如果设置了分布，首页页码
						//search : true, // 是否显示搜索框
						showColumns : false, // 是否显示内容下拉框（选择显示的列）
						sidePagination : "server", // 设置在哪里进行分页，可选值为"client" 或者 "server"
						queryParams : function(params) {
							return {
								//说明：传入后台的参数包括offset开始索引，limit步长，sort排序列，order：desc或者,以及所有列的键值对
								limit: params.limit,
								offset:params.offset,
					            realName:$('#searchName').val()
					           // username:$('#searchName').val()
							};
						},
						// //请求服务器数据时，你可以通过重写参数的方式添加一些额外的参数，例如 toolbar 中的参数 如果
						// queryParamsType = 'limit' ,返回参数必须包含
						// limit, offset, search, sort, order 否则, 需要包含:
						// pageSize, pageNumber, searchText, sortName,
						// sortOrder.
						// 返回false将会终止请求
						columns : [
								{
									checkbox : true
								},
																{
									field : 'merchantId', 
									title : '商户号' 
								},
																{
									field : 'phone', 
									title : '手机号' 
								},
																{
									field : 'realName', 
									title : '用户名'
								},
																{
                                	field : 'idCardNum',
                                	title : '身份证号'
                                },
																{
									field : 'themeId', 
									title : '活动主题id' 
								},
																{
									field : 'themeName', 
									title : '活动主题名称' 
								},
																{
									field : 'themePrice', 
									title : '主题价格' ,
									formatter: function (value, row, index) {
                                        return row.themePrice/100+"元";
                                     }
								},
																{
									field : 'referrerName',
									title : '推荐人姓名' 
								},
																{
									field : 'referrerPhone', 
									title : '推荐人手机号' 
								},
																{
									field : 'isUsed', 
									title : '0未使用 1已使用' 
								},
																{
									field : 'sendMsg',
									title : '是否发送短信',
									formatter : function(value, row, index) {
									    if (row.sendMsg == 0) {
                                            return "未发送";
                                        } else if (row.sendMsg == 1) {
                                            return "未发送成功";
                                        } else if (row.sendMsg == 2) {
                                            return "发送成功";
                                        }
									}
								},
																{
									title : '操作',
									field : 'id',
									align : 'center',
									formatter : function(value, row, index) {
										var e = '<a class="btn btn-primary btn-sm" href="#" mce_href="#" title="编辑" onclick="edit(\''
												+ row.id
												+ '\')"><i class="fa fa-edit"></i></a> ';
										var d = '<a class="btn btn-warning btn-sm" href="#" title="删除"  mce_href="#" onclick="remove(\''
												+ row.id
												+ '\')"><i class="fa fa-remove"></i></a> ';
										var f = '<a class="btn btn-success btn-sm" href="#" title="发送短信"  mce_href="#" onclick="sendMsg(\''
												+ row.phone+","+row.id+","+row.realName+","+row.activityId+","+row.qrCodeUrl
												+ '\')"><i class="fa fa-key"></i></a> ';
										return d + f;
									}
								} ]
					});
}
function reLoad() {
	$('#exampleTable').bootstrapTable('refresh');
}
function add() {
	layer.open({
		type : 2,
		title : '增加',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/add' // iframe的url
	});
}
function edit(id) {
	layer.open({
		type : 2,
		title : '编辑',
		maxmin : true,
		shadeClose : false, // 点击遮罩关闭层
		area : [ '800px', '520px' ],
		content : prefix + '/edit/' + id // iframe的url
	});
}
function remove(id) {
	layer.confirm('确定要删除选中的记录？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix+"/remove",
			type : "post",
			data : {
				'id' : id
			},
			success : function(r) {
				if (r.code==0) {
					layer.msg(r.msg);
					reLoad();
				}else{
					layer.msg(r.msg);
				}
			}
		});
	})
}

function resetPwd(id) {
}
function batchRemove() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要删除的数据");
		return;
	}
	layer.confirm("确认要删除选中的'" + rows.length + "'条数据吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		var phones = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['id'];
			phones[i] = row['phone'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids,
				"phones" : phones
			},
			url : prefix + '/batchRemove',
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {

	});
}
function sendMsg(phone) {
	layer.confirm('确定要发送短信？', {
		btn : [ '确定', '取消' ]
	}, function() {
		$.ajax({
			url : prefix+"/sendMsg",
			type : "post",
			data : {
				'phone' : phone
			},
			success : function(r) {
				if (r.code==0) {
					layer.msg(r.msg);
					reLoad();
				}else{
					layer.msg(r.msg);
				}
			}
		});
	})
}
function batchSendMsg() {
	var rows = $('#exampleTable').bootstrapTable('getSelections'); // 返回所有选择的行，当没有选择的记录时，返回一个空数组
	if (rows.length == 0) {
		layer.msg("请选择要发送短信的客户！");
		return;
	}
	layer.confirm("确认要给选中的'" + rows.length + "'个用户发送短信吗?", {
		btn : [ '确定', '取消' ]
	// 按钮
	}, function() {
		var ids = new Array();
		var phones = new Array();
		var qrCodeUrls = new Array();
		var realNames = new Array();
		var activityIds = new Array();
		// 遍历所有选择的行数据，取每条数据对应的ID
		$.each(rows, function(i, row) {
			ids[i] = row['id'];
			phones[i] = row['phone'];
			qrCodeUrls[i] = row['qrCodeUrl'];
			realNames[i] = row['realName'];
			activityIds[i] = row['activityId'];
		});
		$.ajax({
			type : 'POST',
			data : {
				"ids" : ids,
				"phones" : phones,
				"qrCodeUrls" : qrCodeUrls,
				"realNames" : realNames,
				"activityIds" : activityIds
			},
			url : prefix + '/batchSendMsg',
			success : function(r) {
				if (r.code == 0) {
					layer.msg(r.msg);
					reLoad();
				} else {
					layer.msg(r.msg);
				}
			}
		});
	}, function() {

	});
}