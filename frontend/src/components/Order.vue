<template>
    <div>
        <Number
            label="Qty"
            v-model="value.qty"
            :editMode="editMode"
        />
        <String
            label="UserId"
            v-model="value.userId"
            :editMode="editMode"
        />
        <Date
            label="OrderDate"
            v-model="value.orderDate"
            :editMode="editMode"
        />
        <InventoryId
            offline
            label="inventoryId"
            v-model="value.inventoryId"
            :editMode="editMode"
            @change="change"
        />
        <Address
            offline
            label="Address"
            v-model="value.address"
            :editMode="editMode"
            @change="change"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'Order',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "orders",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
