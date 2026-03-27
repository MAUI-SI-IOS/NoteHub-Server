package com.mauisiios.notehub_server.dto.ws

sealed class EditSyncAction(val actionKeyword: String) {
    data object Read : EditSyncAction("readNote")
    data object Create : EditSyncAction("createNote")
    data object Update : EditSyncAction("updateNote")
    data object Delete : EditSyncAction("deleteNote")

}

interface IEditSyncAction {
    val action: EditSyncAction
}

data class ReadNoteSyncAction(
    val id: Long,
): IEditSyncAction {
    override val action: EditSyncAction
        get() = EditSyncAction.Read
}

data class CreateNoteSyncAction(
    val title: String,
    val content: String,
): IEditSyncAction {
    override val action: EditSyncAction
        get() = EditSyncAction.Create
}

data class UpdateNoteSyncAction(
    val id: Long,
    val title: String,
    val content: String,
): IEditSyncAction {
    override val action: EditSyncAction
        get() = EditSyncAction.Update
}

data class DeleteNoteSyncAction(
    val id: Long,
): IEditSyncAction {
    override val action: EditSyncAction
        get() = EditSyncAction.Delete
}


