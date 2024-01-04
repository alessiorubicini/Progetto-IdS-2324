import { ContentStatus } from "./contentstatus";

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
