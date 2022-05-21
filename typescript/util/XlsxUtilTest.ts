import * as xlsxUtil from './xlsxUtil';
type TestType = {
    userId : string;
    phoneNumber : string;
}
(() => {
    const path = "./"
    const fileName = `${path}xlsxUtilTest.csv`;
    const exportFileName = `${path}exportName2.xlsx`;
    const data = xlsxUtil.xlsxReadToObject<TestType>(fileName, ['userId','phoneNumber'],['userId']);
    xlsxUtil.writeObjectToXlsx<TestType>(data, {newFileName : exportFileName});
})()