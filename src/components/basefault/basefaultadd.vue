<!-- html部分 -->
<template>
	<div>
		<h1>新增故障</h1>
		<el-select v-model="devid" placeholder="请选择斗轮机">
			<el-option  v-for="item in options"  :label="item.devname"  :value="item.devid"> </el-option>
		</el-select>
		<el-input style='width: 180px;' v-model='cause' placeholder="请输入斗故障原因"></el-input>
		<el-input style='width: 180px;' v-model='faultuser' placeholder="请输入报告人"></el-input>
		<el-date-picker  v-model="faulttime"  type="datetime" value-format="yyyy-MM-dd"  placeholder="选择日期时间"></el-date-picker>
		<el-row style='margin-top: 20px;text-align: center;'>
		  <el-col :span="24" ><el-button type='primary' @click='saveAdd'>确定</el-button> <el-button @click='cancel'>取消</el-button> </el-col>
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
				devid:'',
				cause:'',
				faultuser:'',
				faulttime:'',
				faultId:''	
			};
		},
		methods:{
			saveAdd(){
				// 后端网址
				var url = this.baseUrl+"/produceFault/insert"
				// 传递给后端的数据
				var data = {cause:this.cause,faultuser:this.faultuser,faulttime:this.faulttime,faultId:this.faultId,devid:this.devid};
				this.$axios.post(url,this.$qs.stringify(data),{
					headers: {
						'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
					}
				}).then(res=>{
					// res是后端的响应
					this.$message("添加成功");
					this.$router.push({path:'/basefaultlist'});
				})
			},cancel(){
				this.$router.push({path:'/basefaultlist'});
			}		
		},
		
		mounted:function(){
			// 后端网址
			var url = this.baseUrl+"/baseDevice/list"
			this.$axios.post(url,{
				headers: {
					'Content-Type':'application/x-www-form-urlencoded; charset=UTF-8'
				}
			}).then(res=>{
				// res是后端的响应
				this.options=res.data
			})
		
			
		}

	}
</script>
<!-- css部分 -->
<style>

</style>
