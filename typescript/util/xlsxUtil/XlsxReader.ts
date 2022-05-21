import * as xlsx from 'xlsx';

export function xlsxReadToObject<TYPE>(fileName: string, fields: (keyof TYPE)[], requiredFields ?: (keyof TYPE)[]): TYPE[] | null{
    const xlsxFile = xlsx.readFile(fileName, {type: 'binary', sheetStubs: true});
    const json = xlsx.utils.sheet_to_json<TYPE>(xlsxFile.Sheets[xlsxFile.SheetNames[0]], {defval: null});
    const requiredFieldChecker = requiredFields ? (xlsxData: TYPE) => {
       return requiredFields.every(item => !!xlsxData[item]);
    } : (xlsxData: TYPE) => true;

    const headerCheck = fields.every(field => Object.keys(json[0]).includes(field as string));
    const requiredCheck = json.every(data => requiredFieldChecker(data));

    if (headerCheck && requiredCheck) {
        return json.map(doc => {
            const result = {};
            for(const field of fields){
                result[(field as string)] = doc[field];
            }
            return result;
        }) as TYPE[];
    }
    return null;
}


