package com.capgemini.capservice.scrumboard;

import com.capgemini.capcore.scrumboard.ScrumBoard;
import com.capgemini.capcore.scrumboard.ScrumNote;

public class ScrumBoardServiceImpl implements ScrumBoardService {
	private ScrumBoard scrumBoard;
	
	public ScrumBoardServiceImpl() {
		scrumBoard = ScrumBoard.getInstance();
	}
	
	/* (non-Javadoc)
	 * @see com.capgemini.capservice.scrumboard.ScrumBoardService#moveFromNotStartedToInProgress(java.lang.Long)
	 */
	public ScrumBoard moveFromNotStartedToInProgress(Long noteId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.capgemini.capservice.scrumboard.ScrumBoardService#moveFromInProgressToDone(java.lang.Long)
	 */
	public ScrumBoard moveFromInProgressToDone(Long noteId) {
		// TODO Auto-generated method stub
		return null;
		
	}

	/* (non-Javadoc)
	 * @see com.capgemini.capservice.scrumboard.ScrumBoardService#moveFromInProgressToNotStarted(java.lang.Long)
	 */
	public ScrumBoard moveFromInProgressToNotStarted(Long noteId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.capgemini.capservice.scrumboard.ScrumBoardService#moveFromDoneToInProgress(java.lang.Long)
	 */
	public ScrumBoard moveFromDoneToInProgress(Long noteId) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.capgemini.capservice.scrumboard.ScrumBoardService#createNotStartedScrumnote(com.capgemini.capcore.scrumboard.ScrumNote)
	 */
	public ScrumBoard createNotStartedScrumNote(ScrumNote aNote) {
		scrumBoard.getNotStartedList().add(aNote);
		return scrumBoard;
	}
	
	

}
