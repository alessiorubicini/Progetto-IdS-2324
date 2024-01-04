import { ContentStatus } from "./contentstatus";
import { Media } from "./media";
import { Point } from "./point";
import { User } from "./user";

export interface Content {
	id: number;
	title: string;
	description: string;
	publicationDate: Date;
	status: ContentStatus;
	authorId: number;
	pointId: number;
	mediaUrl: string;
	contestId?: number;
}
