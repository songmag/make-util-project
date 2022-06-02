# make-util-project

---

### Java Util


### Typescript Util

- XLSX Util

### xlsxReadToObject<TYPE>

args

> fileName : string

> fields: (keyof Type)[]

> requiredFields : (keyof Type)[] :: nullable

result

> Type[] | null


### function writeObjectToXlsx<Type>

args

> data : Type[]

> options : {
	newFileName : string; :: nullable
	headers : string[]; :: nullable
  } :: nullable

result

> void  
