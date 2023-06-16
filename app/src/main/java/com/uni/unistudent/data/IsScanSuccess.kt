package com.uni.unistudent.data

interface IsScanSuccess {

    fun isScanSuccess(flag: Boolean, qr:String)


    companion object {
        private var listener: IsScanSuccess? = null
        fun setListener(listener: IsScanSuccess) {
            this.listener = listener
        }

        fun set(flag: Boolean,qr: String) {
            listener?.isScanSuccess(flag,qr)
        }
    }
}