/**
 * hanFixRecord管理初始化
 */
var Fix = {
    id: "FixTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Fix.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '维修id', field: 'id', visible: true, align: 'center', valign: 'middle',formatter:paramsMatter},
            {title: '维修用户id', field: 'customId', visible: true, align: 'center', valign: 'middle',formatter:paramsMatter},
            {title: '是否已经付款,填写是或者不是', field: 'ispay', visible: true, align: 'center', valign: 'middle',width:120,formatter:paramsMatter},
            {title: '该次维修费用', field: 'cost', visible: true, align: 'center', valign: 'middle',width:120,formatter:paramsMatter},
            {title: '客户维修车型', field: 'car01', visible: true, align: 'center', valign: 'middle',width:120,formatter:paramsMatter},
            {title: '维修项目', field: 'fixProgram', visible: true, align: 'center', valign: 'middle',formatter:paramsMatter},
            {title: '维修时间', field: 'fixTime', visible: true, align: 'center', valign: 'middle',formatter:paramsMatter},
            {title: '使用零件', field: 'usePart', visible: true, align: 'center', valign: 'middle',formatter:paramsMatter},
            {title: '备注', field: 'rem01', visible: true, align: 'center', valign: 'middle',formatter:paramsMatter},
            {title: '创建人', field: 'createBy', visible: true, align: 'center', valign: 'middle',formatter:paramsMatter},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle',formatter:paramsMatter}
    ];
};
function paramsMatter(value, row, index) {
    // value = value.replace(/\s+/g,'&nbsp;')//替换空格
    // value = value.replace(/\},/,'},\n');//换行
    var span=document.createElement('span');
    span.setAttribute('title',value);
    span.innerHTML = value;
    return span.outerHTML;
}
/**
 * 检查是否选中
 */
Fix.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Fix.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加hanFixRecord
 */
Fix.openAddFix = function () {
    var index = layer.open({
        type: 2,
        title: '添加hanFixRecord',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/fix/fix_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看hanFixRecord详情
 */
Fix.openFixDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: 'hanFixRecord详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/fix/fix_update/' + Fix.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除hanFixRecord
 */
Fix.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/fix/delete", function (data) {
            Feng.success("删除成功!");
            Fix.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("fixId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询hanFixRecord列表
 */
Fix.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Fix.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Fix.initColumn();
    var table = new BSTable(Fix.id, "/fix/list", defaultColunms);
    table.setPaginationType("client");
    Fix.table = table.init();
});
