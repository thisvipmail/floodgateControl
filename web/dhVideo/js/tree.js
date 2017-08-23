/**
 * Created by Administrator on 2017/1/16.
 */

var json = {status:{}};
var treeStr = "";
var createTree = function(xml){
    var xmlDoc = loadXML(xml);
    var parentNode = xmlDoc.getElementsByTagName("Organization")[0].childNodes[1];
    var department = parentNode.childNodes;
    var device = $(xmlDoc.getElementsByTagName("Organization")[0].childNodes[3]).children("Device");

    treeStr = '<div class="panel-group" id="level_0">';

    dealDept(department,parentNode);
    
    getDevice(device);
    recurTree(department,-1,1,"level_0");
    treeStr += "</div>";
    return treeStr;
}

var dealDept = function(nodes,parentNode){

    $(nodes).each(function(rowIndex,node) {
        if(node.nodeName == "Device" ){
            return;
        }

        if(node.childNodes.length == 0 || node.nodeName == "#text"){
            parentNode.removeChild(node);
            return;
        }

        dealDept(node.childNodes,node)

    });
    if(nodes.length == 0){
        parentNode.parentNode.removeChild(parentNode)
    }
}

var recurTree = function(nodes,level,index,pid){
    level++;
    var rowNum = 0;
    $(nodes).each(function(rowIndex,node) {
        if( node.nodeName == "Channel"  ){
            return;
        }
        if(node.nodeName == "Device" ){
            var device = node.getAttribute("id")
            if(json[device] == undefined){
            }else{
            	 var style = 'style="color: #000000"';
                 var divContent = '<div class="greenCircle">&nbsp;&nbsp;&nbsp;&nbsp;</div>';
                 if(json.status[device] != 1){
                     style = 'style="color: #777777"';
                     divContent = '<div class="redCircle">&nbsp;&nbsp;&nbsp;&nbsp;</div>';
                 }
                 var chanels = json[device].chanels;
                 chanels.forEach(function(chanel){
                     if(json.status[chanel.chid]){
                         var st = json.status[chanel.chid]
                         if(st != 1){
                             style = 'style="color: #777777"';
                             divContent = '<div class="redCircle">&nbsp;&nbsp;&nbsp;&nbsp;</div>';
                         }
                     }
                     treeStr += '<div '+style+' class="panel-body-padding" id="'+chanel.chid+'" onclick="ButtonStartRealplayByHWND_onclick(this.id)">'+divContent+chanel.chnm+'</div>';
                 });
            }
            return;
        }

        if(node.nodeName != "#text"){
            var coding = node.getAttribute("coding")
            var name = node.getAttribute("name")
            rowNum++;
            treeStr +=
                '<div class="panel panel-default"><div class="panel-heading">' +
                '<h4 class="panel-title collapsed" data-toggle="collapse" data-parent="#'+pid+'" href="#level_'+level+'_-'+pid.substring(6,pid.length)+'-_'+index+'_'+rowNum+'_" aria-expanded="false">'+
                name + '</h4>'+
                '</div>'+
                '<div id="level_'+level+'_-'+pid.substring(6,pid.length)+'-_'+index+'_'+rowNum+'_" class="panel-collapse collapse">'+
                '<div id="level_'+level+'_-'+pid.substring(6,pid.length)+'-_'+index+'_'+rowNum+'" class="panel-body">';

            recurTree(node.childNodes,level,rowNum,'level_'+level+'_-'+pid.substring(6,pid.length)+'-_'+index+'_'+rowNum);
            treeStr += '</div></div></div>';
        }
    });
}

var getDevice = function(nodes){
    for (var i=0;i<nodes.length;i++){
        var device = nodes[i];
        var devid = device.getAttribute("id");
        var devnm = device.getAttribute("name")
        var chanelArr = [];
        json[devid] = {"name":devnm,"chanels":chanelArr};
        $(device.childNodes).each(function(index,unitNode){
            if(unitNode.nodeName != "#text"){
                var type = unitNode.getAttribute("type");
                if(type == "1"){
                    $(unitNode.childNodes).each(function(index,chanel){
                        if(chanel.nodeName != "#text"){
                            var chid = chanel.getAttribute("id");
                            var chnm = chanel.getAttribute("name")
                            chanelArr.push({"chid":chid,"chnm":chnm});
                        }
                    });
                }
            }
        });
    }
}