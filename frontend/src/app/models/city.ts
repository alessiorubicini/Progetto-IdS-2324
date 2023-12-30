import { Contest } from "./contest";
import { Point } from "./point";

export interface City {
	id: number;
	cadastralCode: string;
	name: string;
	region: string;
	province: string;
	longitude: number;
	latitude: number;
	istatCode: string;
	points: Point[];
	contests: Contest[];
}
