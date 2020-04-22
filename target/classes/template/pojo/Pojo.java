package ${package_pojo};

<#if swagger==true>
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
</#if>
import javax.persistence.*;
import java.io.Serializable;
<#list typeSet as set>
import ${set};
</#list>
/**
 * Demo ${Table}实体类
 *
 * @author lishiquan
 */
<#if swagger==true>
@ApiModel(description = "${Table}",value = "${Table}")
</#if>
@Table(name="${TableName}")
public class ${Table} implements Serializable{

<#list models as model>
	<#if swagger==true>
	@ApiModelProperty("${model.desc!""}")
	</#if>
	<#if model.id==true>
	@Id
	<#if model.identity=='YES'>
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	</#if>
	</#if>
	private ${model.simpleType} ${model.name};

</#list>


<#list models as model>
	public ${model.simpleType} get${model.upperName}() {
		return ${model.name};
	}
	public void set${model.upperName}(${model.simpleType} ${model.name}) {
		this.${model.name} = ${model.name};
	}
</#list>


}
