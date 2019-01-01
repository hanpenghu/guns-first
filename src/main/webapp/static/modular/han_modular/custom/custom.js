/**
 * hanService管理初始化
 */
var Custom = {
    id: "CustomTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Custom.initColumn = function () {
    return [
            {field: 'selectItem', radio: true},
            {title: '添加修车记录', field: 'addFixRec', visible: true, align: 'center', valign: 'middle',width:120,formatter:paramsMatter1},
            {title: '查看修车记录', field: 'fixRecLook', visible: true, align: 'center', valign: 'middle',width:120,formatter:paramsMatter},
            {title: '客户id', field: 'id', visible: true, align: 'center', valign: 'middle',width:120,formatter:paramsMatter},
            {title: '客户姓名', field: 'name', visible: true, align: 'center', valign: 'middle',width:120,formatter:paramsMatter},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle',width:120,formatter:paramsMatter},
            {title: '客户电话1', field: 'phone01', visible: true, align: 'center', valign: 'middle',width:120,formatter:paramsMatter},
            {title: '客户电话2', field: 'phone02', visible: true, align: 'center', valign: 'middle',width:120,formatter:paramsMatter},
            {title: '客户电话3', field: 'phone03', visible: true, align: 'center', valign: 'middle',width:120,formatter:paramsMatter},
            {title: '客户电话4', field: 'phone04', visible: true, align: 'center', valign: 'middle',width:120,formatter:paramsMatter},
            {title: '客户常用车型01', field: 'car01', visible: true, align: 'center', valign: 'middle',width:120,formatter:paramsMatter},
            {title: '客户常用车型02', field: 'car02', visible: true, align: 'center', valign: 'middle',width:120,formatter:paramsMatter},
            {title: '客户常用车型03', field: 'car03', visible: true, align: 'center', valign: 'middle',width:120,formatter:paramsMatter},
            {title: '客户年龄', field: 'age', visible: true, align: 'center', valign: 'middle',width:120,formatter:paramsMatter},
            {title: '备注一', field: 'rem01', visible: true, align: 'center', valign: 'middle',width:120,formatter:paramsMatter},
            {title: '备注二', field: 'rem02', visible: true, align: 'center', valign: 'middle',width:120,formatter:paramsMatter},
            {title: '备注三', field: 'rem03', visible: true, align: 'center', valign: 'middle',width:120,formatter:paramsMatter},
            {title: '介绍人', field: 'introduce', visible: true, align: 'center', valign: 'middle',width:120,formatter:paramsMatter},
            {title: '介绍人电话', field: 'introducePhone', visible: true, align: 'center', valign: 'middle',width:120,formatter:paramsMatter},
            {title: '创建人', field: 'createBy', visible: true, align: 'center', valign: 'middle',width:120,formatter:paramsMatter}

    ]
}
function paramsMatter(value, row, index) {
    // value = value.replace(/\s+/g,'&nbsp;')//替换空格
    // value = value.replace(/\},/,'},\n');//换行
    var span=document.createElement('span');
    span.setAttribute('title',value);
    span.innerHTML = value;
    return span.outerHTML;
}


function paramsMatter1(value, row, index) {
    var a="<a href='javascript:;' onclick='fixAdd(this)' data-bind='"+value+"'>点击添加维修记录</a>"
    return a;
}

function fixAdd(e) {
    //alert($(e).attr("data-bind"))
    Feng.newCrontab("/fix/fix_add"+$(e).attr("data-bind"),"添加修车记录")
}




/**
 * 检查是否选中
 */
Custom.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Custom.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加hanService
 */
Custom.openAddCustom = function () {
    var index = layer.open({
        type: 2,
        title: '添加hanService',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/custom/custom_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看hanService详情
 */
Custom.openCustomDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: 'hanService详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/custom/custom_update/' + Custom.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除hanService
 */
Custom.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/custom/delete", function (data) {
            Feng.success("删除成功!");
            Custom.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("customId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询hanService列表
 */
Custom.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Custom.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Custom.initColumn();
    var table = new BSTable(Custom.id, "/custom/list", defaultColunms);
    // table.setPaginationType("client");
    table.setPaginationType("server");
    Custom.table = table.init();



});



