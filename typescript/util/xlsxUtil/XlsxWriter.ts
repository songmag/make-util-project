import * as xlsx from 'xlsx';

export function writeObjectToXlsx<Type>( data: Type[], options ?: { newFileName?: string; headers?: string[];}): void {
    const now = new Date();
    let newFileName = `Export_${now.getFullYear()}_${now.getMonth()}_${now.getDay()}.csv`;
    let headers;
    if(options){
        headers = options.headers;
        newFileName = options.newFileName ? options.newFileName : newFileName;
    }
    const sheet = xlsx.utils.json_to_sheet([]);
    if (headers) {
        xlsx.utils.sheet_add_aoa<string>(sheet, [headers], { origin: 'A1' });
        xlsx.utils.sheet_add_json<Type>(sheet, data, { origin: 'A2', skipHeader: true });
    } else {
        xlsx.utils.sheet_add_json<Type>(sheet, data);
    }
    try {
        const workbook = xlsx.utils.book_new();
        xlsx.utils.book_append_sheet(workbook, sheet);
        xlsx.writeFile(workbook, newFileName ? newFileName : `Export_${new Date()}`);
    }catch(e){
        console.log(e);
    }
}
