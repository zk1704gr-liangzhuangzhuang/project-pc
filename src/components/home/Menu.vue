<!-- html部分 -->
<template>
	<div style="height: 100%;">
		<!-- 菜单 -->
		<el-menu :default-active='$store.state.defaultActive'>
			<span v-for="obj in arr">
				<!-- 没有子菜单 -->
				<el-menu-item v-show='!obj.children' :index='obj.index' @click='fn(obj)'>
					<span slot="title">{{obj.text}}</span>
				</el-menu-item>
				<!-- 有子菜单 -->
				<el-submenu v-show='obj.children' :index='obj.index'>
					<template slot="title">
					  <span>{{obj.text}}</span>
					</template>
					<el-menu-item-group>
					  <el-menu-item v-for='item in obj.children' :index='item.index' :key='item.text' @click='fn(item)'>{{item.text}}</el-menu-item>
					</el-menu-item-group>
				</el-submenu>
			</span>
		</el-menu>
	</div>
</template>
<!-- js部分 -->
<script>
	export default {
		name:'',
		data() {
			return {
				arr:[{text:'首页',index:'101',url:'/'},
					 {text:'基本信息',index:'102',children:[
						 {text:'企业信息',index:'1021',url:'/CompList'},
						 {text:'设备类别',index:'1023',url:'/DevtypeList'},
						 {text:'人员信息',index:'1022',url:'/MainTable'},
						 {text:'设备信息',index:'1024',url:'/Devicelist'},
						  {text:'流程信息',index:'1025',url:'/baseFlowlist'}
					 ]},
					 {text:'生产作业',index:'1030',children:[
					 	 {text:'报岗',index:'1031',url:'Control'},
						 {text:'中控',index:'1032',url:''},
					 	 {text:'作业信息',index:'1033',url:''},
						 {text:'故障信息',index:'1034',url:'basefaultlist'},
						 {text:'维修记录',index:'1035',url:'produceRepairlist'},
					 ]},
					 {text:'能耗信息',index:'104',children:[
					 	 {text:'能耗信息',index:'1041',url:''},
					 	 {text:'折标煤系数',index:'1042',url:''},
					 ]},
					 {text:'统计信息',index:'105',children:[
					 	 {text:'港口能耗对比',index:'1051',url:''},
					 	 {text:'作业量统计',index:'1052',url:''},
						 {text:'设备完好率',index:'1053',url:''},
						 {text:'设备利用率',index:'1054',url:'usage'},
						 {text:'成本核算信息',index:'1055',url:''},
					 	 
					 ]},
					 {text:'模型建立与展示',index:'106',children:[
					 	 {text:'企业用能模型',index:'1061',url:'Canusemodel'},
					 	 {text:'企业产销模型',index:'1062',url:'Pinmodel'},
					 	
					 ]},
					 {text:'企业数据采集',index:'107',children:[
					 	 {text:'数据采集',index:'1071',url:''}
					 ]},
					 
					 
				]
			};
		},
		methods:{
			fn(obj){
				// 路由跳转
				this.$router.push({path:obj.url});
				// 添加到tags
				this.$store.commit('addTag',{name:obj.text,type:'warning',url:obj.url,index:obj.index});
			}
		}
	}
</script>
<!-- css部分 -->
<style>
.el-menu{
	background: #F4F4F4;
}
</style>
