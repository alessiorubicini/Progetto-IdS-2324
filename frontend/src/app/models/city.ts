import { Contest } from "./contest";
import { Point } from "./point";
import {Content} from "./content";

export interface City {
	id?: number;
	cadastralCode: string;
	name: string;
	region: string;
	province: string;
	longitude: number;
	latitude: number;
	istatCode: string;
	contests?: Contest[]
	points?: Point[]
}
