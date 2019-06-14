import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import Index from '@/components/home/Index'
import Welcome from '@/components/home/Welcome'
import CompList from '@/components/baseInfo/CompList'
import CompAdd from '@/components/baseInfo/CompAdd'
import CompEdit from '@/components/baseInfo/CompEdit'
import DevtypeList from '@/components/basedevtype/DevtypeList'
import DevtypeAdd from '@/components/basedevtype/DevtypeAdd'
import DevtypeEdit from '@/components/basedevtype/DevtypeEdit'
import MainTable from '@/components/baseuser/MainTable'
import baseuseradd from '@/components/baseuser/baseuseradd'
import Devicelist from '@/components/basedevice/Devicelist'
import Deviceadd from '@/components/basedevice/Deviceadd'
import DeviceEdit from '@/components/basedevice/DeviceEdit'
import login from '@/components/home/login'
import baseFlowlist from '@/components/baseFlow/baseFlowlist'
import baseFlowadd from '@/components/baseFlow/baseFlowadd'
import baseFlowEdit from '@/components/baseFlow/baseFlowEdit'
import basefaultlist from '@/components/basefault/basefaultlist'
import basefaultadd from '@/components/basefault/basefaultadd'
import basefaultEdit from '@/components/basefault/basefaultEdit'
import produceRepairlist from '@/components/produceRepair/produceRepairlist'
import produceRepairEdit from '@/components/produceRepair/produceRepairEdit'
import produceRepairadd from '@/components/produceRepair/produceRepairadd'
import usage from '@/components/usage'

import Canusemodel from '@/components/model/Canusemodel'
import Pinmodel from '@/components/model/Pinmodel'




Vue.use(Router)

export default new Router({
	mode:'history',
  routes: [
		{path: '/login',name: 'login',component: login},
    {
      path: '/',name: 'Index',component: Index,
			children:[
					{path:'/',component:Welcome},
					{path:'CompList',component:CompList,name:'CompList'},
					{path:'CompAdd',component:CompAdd},
					{path:'CompEdit',component:CompEdit,name:'CompEdit'},
					{path:'MainTable',component:MainTable},
					{path:'DevtypeList',component:DevtypeList,name:'DevtypeList'},
					{path:'DevtypeAdd',component:DevtypeAdd},
					{path:'DevtypeEdit',component:DevtypeEdit,name:'DevtypeEdit'},
					{path:'baseuseradd',component:baseuseradd,name:'baseuseradd'},
					{path:'Devicelist',component:Devicelist,name:'Devicelist'},
					{path:'Deviceadd',component:Deviceadd,name:'Deviceadd'},
					{path:'DeviceEdit',component:DeviceEdit,name:'DeviceEdit'},
					{path:'baseFlowlist',component:baseFlowlist,name:'baseFlowlist'},
					{path:'baseFlowadd',component:baseFlowadd,name:'baseFlowadd'},
					{path:'baseFlowEdit',component:baseFlowEdit,name:'baseFlowEdit'},
					{path:'basefaultlist',component:basefaultlist,name:'basefaultlist'},
					{path:'basefaultadd',component:basefaultadd,name:'basefaultadd'},
					{path:'basefaultEdit',component:basefaultEdit,name:'basefaultEdit'},
					{path:'produceRepairlist',component:produceRepairlist,name:'produceRepairlist'},
					{path:'produceRepairEdit',component:produceRepairEdit,name:'produceRepairEdit'},
					{path:'produceRepairadd',component:produceRepairadd,name:'produceRepairadd'},
					{path:'Canusemodel',component:Canusemodel,name:'Canusemodel'},
					{path:'Pinmodel',component:Pinmodel,name:'Pinmodel'},
					{path:'usage',component:usage,name:'usage'},
			]
    }
		
		
  ]
})
