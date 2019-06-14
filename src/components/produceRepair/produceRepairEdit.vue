<!-- html部分 -->
<template>
	<div>
		<h1>修改故障</h1>
		<el-select v-model="devid" placeholder="请选择斗轮机">
			<el-option  v-for="item in options"  :label="item.devname"  :value="item.devid"></el-option>
		</el-select>
		<el-input style='width: 180px;' v-model='cause' placeholder="请输入斗故障原因"></el-input>
		<el-input style='width: 180px;' v-model='cost' placeholder="请输入报告人"></el-input>
		<el-input style='width: 180px;' v-model='repairdate' placeholder="请输入故障时间(分钟)"></el-input>
		<el-row style='margin-top: 20px;text-align: center;'>
		  <el-col :span="24" ><el-button type='primary' @click='saveAdd'>修改</el-button> <el-button @click='cancel'>取消</el-button> </el-col>
		</el-row>
	</div>
</template>
<!-- js部分 -->
<script>
	export default {
		name:'',
		data() {
			return {
				options:[],
				repairid:'',
				devid:'',
				cause:'',
				cost:'',
				repairdate:''	
			};
		},
		methods:{
			
		},
		mounted:function(){
			
	
		}

	}
</script>
<!-- css部分 -->
<style>

</style>
