/**
 * Created by Administrator on 2017/7/21.
 */

const data = {
    //ysjh: 'http://10.35.0.171:9300/p2pd/servlet/dispatch?b_action=cognosViewer&ui.action=run&cv.toolbar=false&prompt=false&run.prompt=false&CAMNamespace=BASIC&CAMNamespaceDisplayName=EnterpriseServer&CAMUsername=usera&CAMPassword=null&ui.object=',
    ysjh:'http://10.35.0.171/ibmcognos/cgi-bin/cognos.cgi?b_action=cognosViewer&ui.action=run&run.outputFormat=&run.prompt=false&cv.header=false&cv.toolbar=false&&ui.object=',
    report_y: encodeURI("/content/folder[@name='waterManagerReport']/folder[@name='waterUsePlan']/report[@name='yearPlan']"),
    report_m: encodeURI("/content/folder[@name='waterManagerReport']/folder[@name='waterUsePlan']/report[@name='monthPlan']"),
    report_t: encodeURI("/content/folder[@name='waterManagerReport']/folder[@name='waterUsePlan']/report[@name='tenPlan']"),
    thtfUrl:'http://10.35.0.105/sdnsbd/aloneBusinessPage.jsp?nodeId=',
    sqjkNode:'fetchRealTimeRunData',
    bbtj:encodeURI("/content/folder[@name='南水北调山东段II标']/package[@name='水情综合']/report[@name='建筑物数量统计(预定义)']")
}